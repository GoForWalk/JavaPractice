$(document).ready(function(){
	// options
	var speed = 500; //transition speed - fade
	var autoswitch = false; //auto slider options
	var autoswitch_speed = 5000; //auto slider speed
	
	// add first initial active class
	$(".slide").first().addClass("active");
	
	// hide all slides
	$(".slide").hide();
	
	// show only active class slide
	$(".active").show();
	
	// Next Event Handler
	$('#next').on('click', nextSlide);// call function nextSlide
	
	// Prev Event Handler
	$('#prev').on('click', prevSlide);// call function prevSlide
	
	// Auto Slider Handler
	if(autoswitch == true){
		setInterval(nextSlide,autoswitch_speed);// call function and value 4000
	}
	
	// Switch to next slide
	function nextSlide(){
		$('.active').removeClass('active').addClass('oldActive');
		if($('.oldActive').is(':last-child')){
			$('.slide').first().addClass('active');
		} else {
			$('.oldActive').next().addClass('active');
		}
		$('.oldActive').removeClass('oldActive');
		$('.slide').fadeOut(speed);
		$('.active').fadeIn(speed);
	}
	
	// Switch to prev slide
	function prevSlide(){
		$('.active').removeClass('active').addClass('oldActive');
		if($('.oldActive').is(':first-child')){
			$('.slide').last().addClass('active');
		} else {
			$('.oldActive').prev().addClass('active');
		}
		$('.oldActive').removeClass('oldActive');
		$('.slide').fadeOut(speed);
		$('.active').fadeIn(speed);
    }
    
    $(document).ready(function(){
        var slide =  $('.card')
        $(slide).first().addClass('active-img');
        $(slide).last().addClass('small').addClass('prev');
        $(slide).last().prev('.card').addClass('smaller prevSmall');
        $(slide).first().next('.card').addClass('small next');
        $(slide).first().next('.card').next('.card').addClass('smaller nextSmall');
       
       
     
     $('.next-btn').click(function(e){
         e.preventDefault();
             var Active = $('.active-img'), Prev = $('.prev'), Next = $('.next'), SmallPrev = $('.prevSmall'), SmallNext = $('.nextSmall');
       
         $(Active).addClass('small prev ').removeClass('active-img');
         $(Next).addClass('active-img').removeClass('small next');
         $(Prev).addClass('smaller prevSmall ').removeClass('small prev ');
         $(SmallNext).addClass('small next').removeClass('smaller nextSmall ');
         $(SmallPrev).removeClass('prevSmall').addClass('nextSmall');
        
     });
     $('.prev-btn').click(function(e){
         e.preventDefault();
         var Active = $('.active-img'), Prev = $('.prev'), Next = $('.next'), SmallPrev = $('.prevSmall'), SmallNext = $('.nextSmall');
       
         $(Active).removeClass('active-img').addClass('small next');
         $(Prev).removeClass('small prev').addClass('active-img');
         $(Next).removeClass('small next').addClass('smaller nextSmall');
         $(SmallPrev).addClass('small prev').removeClass('smaller prevSmall');
         $(SmallNext).removeClass('nextSmall').addClass('prevSmall');
         
	 });
	 
	});
	
	// sticky header

	window.onscroll = function(){myFunction()};

	var header = document.getElementById('header');

	var sticky = header.offsetTop;

	function myFunction(){
		if(window.pageYOffset >= sticky){
			header.classList.add('sticky')
		} else {
			header.classList.remove('sticky');
		}
	}

	// close ul

	var closebtns = document.getElementsByClassName('close_btn');
	var i;

	for(i = 0; i < closebtns.length; i++){
		closebtns[i].addEventListener('click',function(){

		this.parentElement.parentElement.style.display = 'none';
		
		})
	}

	// collapsible

	var coll = document.getElementsByClassName("collapsible");
	var i;

	var ohlcData = [];
	var volumeData = [];

	for (i = 0; i < coll.length; i++) {
		coll[i].addEventListener("click", function(){
		this.classList.toggle("active");

		var content = this.nextElementSibling;

		if (content.style.maxHeight){
			content.style.maxHeight = null;
		  } else {
			content.style.maxHeight = content.scrollHeight + "px";
		}

		function round(d) {
			return Math.round(100 * d) / 100;
		}

		//랜덤변수 지정
		
				
		var date = new Date(2020, 2, 20);
		
		var high = Math.random() * 40;
		var close = high - Math.random();
		var low = close - Math.random();
		var open = (high - low) * Math.random() + low;
		
		ohlcData.push([date, round(high), round(low), round(open), round(close)]);
		
		var volume = 100 + 15 * Math.random();
		volumeData.push([date, round(volume)]);
		
		for (var day = 2; day <= 60; day++) {
		
			date = new Date(2020, 2, 19 + day);
		
			high = open + Math.random();
		
			close = high - Math.random();
			low = close - Math.random();
			var oldOpen = open;
			open = (high - low) * Math.random() + low;
		
			if (low > oldOpen) {
				low = oldOpen;
			}
		
			ohlcData.push([date, round(high), round(low), round(open), round(close)]);
		
			volume = volume + 10 * Math.random() - 5;
		
			volumeData.push([date, round(volume)]);
		}

		// 차트 생성
		
			$(this).closest('.collapse').find('.jqChart').jqChart({
				legend: { visible: false },
				border: { lineWidth: 0, padding: 0 },
				tooltips: {
					type: 'shared',
					disabled: true
				},
				crosshairs: {
					enabled: true,
					hLine: false
				},
				animation: { duration: 1 },
				axes: [
					{
						type: 'linear',
						location: 'left',
						width: 30
					}
				],
				series: [
					{
						title: 'Price Index',
						type: 'candlestick',
						data: ohlcData,
						priceUpFillStyle: 'white',
						priceDownFillStyle: 'black',
						strokeStyle: 'black'
					}
				]
			});
		
			$(this).closest('.collapse').find('.jqChartVolume').jqChart({
				legend: { visible: false },
				border: { lineWidth: 0, padding: 0 },
				tooltips: {
					type: 'shared',
					disabled: true
				},
				crosshairs: {
					enabled: true,
					hLine: false
				},
				animation: { duration: 1 },
				axes: [
					{
						type: 'dateTime',
						location: 'bottom'
					},
					{
						type: 'linear',
						location: 'left',
						width: 30
					}
				],
				series: [
					{
						type: 'column',
						data: volumeData,
						fillStyle: 'black'
					}
				]
			});
			


		// 차트 표시

		var isHighlighting = false;
				
		$('.jqChart').bind('dataHighlighting', function (event, data) {

			if (!data) {
				$('.jqChartVolume').jqChart('highlightData', null);
				return;
			}

			$('.open').html(data.open);
			$('.high').html(data.high);
			$('.low').html(data.low);
			$('.close').html(data.close);

			var date = data.chart.stringFormat(data.x, "mmmm d, yyyy");

			$('.date').html(date);

			if (!isHighlighting) {

				isHighlighting = true;

				var index = $.inArray(data.dataItem, ohlcData);
				$('.jqChartVolume').jqChart('highlightData', [volumeData[index]]);
			}

			isHighlighting = false;
		});

		$('.jqChartVolume').bind('dataHighlighting', function (event, data) {

			if (!data) {
				$('.jqChart').jqChart('highlightData', null);
				return;
			}

			
			$('.volume').html(data.y);

			if (!isHighlighting) {

				isHighlighting = true;

				var index = $.inArray(data.dataItem, volumeData);
				$('.jqChart').jqChart('highlightData', [ohlcData[index]]);
			}

			isHighlighting = false;
		});

		ohlcData = [];
		volumeDAta = []; 
		date = new Date(2020, 2, 20);

//차트 초기 표시

		$('.jqChart').jqChart('highlightData', [ohlcData[0]]);
		$('.jqChartVolume').jqChart('highlightData', [volumeData[0]]);


		});
		
}

// 버튼 링크

$('button').click(function(){
	window.open('http://127.0.0.1:5500/WebContent/myweb/trade.html')
});



	


// 실시간 주가





}); // ready end