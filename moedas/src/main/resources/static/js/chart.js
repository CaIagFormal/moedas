/**
 * ---------------------------------------
 * This demo was created using amCharts 5.
 *
 * For more information visit:
 * https://www.amcharts.com/
 *
 * Documentation is available at:
 * https://www.amcharts.com/docs/v5/
 * ---------------------------------------
 */
var dbg_chart;

function genChart(dados,target_div,moeda) {
    var root = am5.Root.new(target_div);

    root.setThemes([
      am5themes_Animated.new(root)
    ]);

    var chart = root.container.children.push(am5xy.XYChart.new(root, {
      panX: true,
      panY: true,
      wheelX: "panX",
      wheelY: "zoomX",
      pinchZoomX:true,
      paddingLeft: 0
    }));

    var easing = am5.ease.linear;

    var cursor = chart.set("cursor", am5xy.XYCursor.new(root, {
      behavior: "none"
    }));
    cursor.lineY.set("visible", true);

    // Gerar dados

    var xAxis = chart.xAxes.push(am5xy.DateAxis.new(root, {
      maxDeviation: 0.2,
      baseInterval: {
        timeUnit: "minute",
        count: 1
      },
      renderer: am5xy.AxisRendererX.new(root, {
        minorGridEnabled:true,
        minGridDistance: 50
      }),
      tooltip: am5.Tooltip.new(root, {})
    }));

    var yAxis = chart.yAxes.push(am5xy.ValueAxis.new(root, {
      renderer: am5xy.AxisRendererY.new(root, {
        pan:"zoom"
      })
    }));

    var series = chart.series.push(am5xy.LineSeries.new(root, {
      name: "Series 1",
      xAxis: xAxis,
      yAxis: yAxis,
      valueYField: "value",
      valueXField: "date",
      tooltip: am5.Tooltip.new(root, {
        pointerOrientation: "horizontal",
        labelText: "{valueY}"
      })
    }));

    // tell that the last data item must create bullet
    dados[dados.length - 1].bullet = true;
    series.data.setAll(dados);


    // Create animating bullet by adding two circles in a bullet container and
    // animating radius and opacity of one of them.
    series.bullets.push(function(root, series, dataItem) {
      // only create sprite if bullet == true in data context
      if (dataItem.dataContext.bullet) {
        var container = am5.Container.new(root, {});
        var circle0 = container.children.push(am5.Circle.new(root, {
          radius: 5,
          fill: am5.color(0xff0000)
        }));
        var circle1 = container.children.push(am5.Circle.new(root, {
          radius: 5,
          fill: am5.color(0xff0000)
        }));

        circle1.animate({
          key: "radius",
          to: 20,
          duration: 1000,
          easing: am5.ease.out(am5.ease.cubic),
          loops: Infinity
        });
        circle1.animate({
          key: "opacity",
          to: 0,
          from: 1,
          duration: 1000,
          easing: am5.ease.out(am5.ease.cubic),
          loops: Infinity
        });

        return am5.Bullet.new(root, {
          locationX:undefined,
          sprite: container
        })
      }
    })

    // Update data every second
    var time = new Date(),
        secondsRemaining = (60 - time.getSeconds()) * 1000;
    secondsRemaining += 1000;

    setTimeout(function() {
        requestData(moeda,series,xAxis,easing);
        chart.set('x',chart.x()+10);
        setInterval(function () {
              requestData(moeda,series,xAxis,easing);
            }, 1000*60);
            chart.set('x',chart.x()+10);
    }, secondsRemaining);

    chart.set("scrollbarX", am5.Scrollbar.new(root, {
      orientation: "horizontal"
    }));

    series.appear(1000);
    chart.appear(1000, 100);
    dbg_chart = chart;
}

function generateDados(target_div,moeda) {
    $.ajax({
        url: "/get_chart_data",
        method: "POST",
        data: {
            moeda: moeda
        },
        success: function(dados) {
            genChart(dados,target_div,moeda);
        }
    })
}

function requestData(moeda,series,xAxis,easing) {
    $.ajax({
        url: "/get_latest_chart",
        method: "POST",
        data: {
            moeda: moeda
        },
        success: function(dado) {
            addData(dado.value,dado.date,series,xAxis,easing);
        }
    })
}

function addData(newValue,time,series,xAxis,easing) {
  var lastDataItem = series.dataItems[series.dataItems.length - 1];

  var lastValue = lastDataItem.get("valueY");
  var lastDate = new Date(lastDataItem.get("valueX"));
  series.data.push({
    date: time,
    value: newValue
  })

  var newDataItem = series.dataItems[series.dataItems.length - 1];
  newDataItem.animate({
    key: "valueYWorking",
    to: newValue,
    from: lastValue,
    duration: 600,
    easing: easing
  });

  // use the bullet of last data item so that a new sprite is not created
  newDataItem.bullets = [];
  newDataItem.bullets[0] = lastDataItem.bullets[0];
  newDataItem.bullets[0].get("sprite").dataItem = newDataItem;
  // reset bullets
  lastDataItem.dataContext.bullet = false;
  lastDataItem.bullets = [];


  var animation = newDataItem.animate({
    key: "locationX",
    to: 0.5,
    from: -0.5,
    duration: 600
  });
  if (animation) {
    var tooltip = xAxis.get("tooltip");
    if (tooltip && !tooltip.isHidden()) {
      animation.events.on("stopped", function () {
        xAxis.updateTooltip();
      })
    }
  }
}

generateDados("usd_chart","USD");
//generateDados("eur_chart","EUR");
//generateDados("btc_chart","BTC");