var ChartsAmcharts = function() {

    var initChartSample1 = function(stuInfo) {
        var chart = AmCharts.makeChart("chart_my_1", {
            "type": "pie",
            "theme": "light",
            "fontFamily": 'Open Sans',
            "color": '#888',
            "dataProvider":stuInfo.fromMajor,
            "valueField": "studentNum",
            "titleField": "majorName",
            "exportConfig": {
                menuItems: [{
                    icon: Metronic.getGlobalPluginsPath() + "amcharts/amcharts/images/export.png",
                    format: 'png'
                }]
            }
        });

        $('#chart_my_1').closest('.portlet').find('.fullscreen').click(function() {
            chart.invalidateSize();
        });
    }

    var initChartSample2 = function(teaInfo) {
        var chart = AmCharts.makeChart("chart_my_2", {
        	"type": "pie",
            "theme": "light",
            "fontFamily": 'Open Sans',
            "color":    '#888',
            "dataProvider": teaInfo.fromCompany,
            "valueField": "teacherNum",
            "titleField": "companyName",
            "exportConfig": {
                menuItems: [{
                    icon: Metronic.getGlobalPluginsPath() + "amcharts/amcharts/images/export.png",
                    format: 'png'
                }]
            }
        });

        $('#chart_my_2').closest('.portlet').find('.fullscreen').click(function() {
            chart.invalidateSize();
        });
    }

    return {
        init: function(stuInfo,teaInfo) {

        	initChartSample1(stuInfo);
            initChartSample2(teaInfo);
            
        }

    };

}();