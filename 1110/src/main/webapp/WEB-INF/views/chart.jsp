<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#chart_div{
		width:700px;
		height:300px;
	}
</style>
</head>
<body>
	<h1>amChart Test</h1>
	<div id="chart_div">
	
	</div>
	
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script src="https://cdn.amcharts.com/lib/4/core.js"></script>
<script src="https://cdn.amcharts.com/lib/4/charts.js"></script>
<script src="https://cdn.amcharts.com/lib/4/themes/material.js"></script>
<script src="https://cdn.amcharts.com/lib/4/lang/de_DE.js"></script>
<script src="https://cdn.amcharts.com/lib/4/geodata/germanyLow.js"></script>
<script src="https://cdn.amcharts.com/lib/4/fonts/notosans-sc.js"></script>
<script src="https://cdn.amcharts.com/lib/4/themes/animated.js"></script>
<script type="text/javascript">
	$(function(){
		// Themes begin
		am4core.useTheme(am4themes_kelly);
		am4core.useTheme(am4themes_animated);
		// Themes end
		
		
		//차트 생성					어디다가 만들거야?:id값 , 어떤 차트 만들거야?
		var chart = am4core.create('chart_div', am4charts.XYChart)
		
		//차트를 만들 정보
		chart.data = [
			{"교과목": "Java", "score":100},
			{"교과목": "Spring", "score":100},
			{"교과목": "Python", "score":98}
			];
		
		//X축 만들기
		var categoryAxis = chart.xAxes.push(new am4charts.CategoryAxis());
		categoryAxis.dataFields.category = "교과목";
		
		//Y축 만들기
		var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
		
		//Series 만들기
	    var series = chart.series.push(new am4charts.ColumnSeries());
	    series.dataFields.valueY = "score";
	    series.dataFields.categoryX = "교과목";
	
	   	series.columns.template.tooltipText = "[bold]{valueY}[/]";
		
	});

</script>
</body>
</html>