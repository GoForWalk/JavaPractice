/**
"Simple Responsive Content Slider" by Michal: https://codepen.io/Kopecky/pen/xswkb

**/


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

	var closebtns = document.getElementsByClassName('close');
	var i;

	for(i = 0; i < closebtns.length; i++){
		closebtns[i].addEventListener('click',function(){

		this.parentElement.parentElement.style.display = 'none';
		
		})
	}

	var coll = document.getElementsByClassName("collapsible");
	var i;

	for (i = 0; i < coll.length; i++) {
		coll[i].addEventListener("click", function(){
		this.classList.toggle("active");

		var content = this.nextElementSibling;

		if (content.style.maxHeight){
			content.style.maxHeight = null;
		  } else {
			content.style.maxHeight = content.scrollHeight + "px";
		  }
	
  });

}



}); // ready end