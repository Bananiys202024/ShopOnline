





//
// <!-- That script for click on star or stars CLICK-->


$( ".jsScriptShow1" ).click(function() {
		$(".ValueForStar").text('VeryBad');
//    		$(".Assesment1").removeClass('hide');
// 		$(".Assesment2").addClass('hide');
// 		$(".Assesment3").addClass('hide');
// 		$(".Assesment4").addClass('hide');
// 		$(".Assesment5").addClass('hide');
   		alert("Your assesment is Very Bad. 1 point from 5.");
		$(".star1").addClass('SheWillBeBrightFromDayOfCreationUniverseToOurDays');
		$(".star2").removeClass('SheWillBeBrightFromDayOfCreationUniverseToOurDays');
		$(".star3").removeClass('SheWillBeBrightFromDayOfCreationUniverseToOurDays');
		$(".star4").removeClass('SheWillBeBrightFromDayOfCreationUniverseToOurDays');
		$(".star5").removeClass('SheWillBeBrightFromDayOfCreationUniverseToOurDays');
		
		$(".forStarsRating").val("1");		
	});
	
$( ".jsScriptShow2" ).click(function() {
	$(".ValueForStar").text('Bad');
// 	    $(".Assesment1").addClass('hide');
// 		$(".Assesment2").removeClass('hide');
// 		$(".Assesment3").addClass('hide');
// 		$(".Assesment4").addClass('hide');
// 		$(".Assesment5").addClass('hide');
		
		alert("Your assesment is Bad. 2 point from 5.");
		$(".star1").addClass('SheWillBeBrightFromDayOfCreationUniverseToOurDays');
		$(".star2").addClass('SheWillBeBrightFromDayOfCreationUniverseToOurDays');
		$(".star3").removeClass('SheWillBeBrightFromDayOfCreationUniverseToOurDays');
		$(".star4").removeClass('SheWillBeBrightFromDayOfCreationUniverseToOurDays');
		$(".star5").removeClass('SheWillBeBrightFromDayOfCreationUniverseToOurDays');
		$(".forStarsRating").val("2");	
});

$( ".jsScriptShow3" ).click(function() {
	$(".ValueForStar").text('Hm...');
// 	    $(".Assesment1").addClass('hide');
// 		$(".Assesment2").addClass('hide');
// 		$(".Assesment3").removeClass('hide');
// 		$(".Assesment4").addClass('hide');
// 		$(".Assesment5").addClass('hide');
		
		alert("Your assesment is Hmmm.... 3 point from 5.");
		$(".star1").addClass('SheWillBeBrightFromDayOfCreationUniverseToOurDays');
		$(".star2").addClass('SheWillBeBrightFromDayOfCreationUniverseToOurDays');
		$(".star3").addClass('SheWillBeBrightFromDayOfCreationUniverseToOurDays');
		$(".star4").removeClass('SheWillBeBrightFromDayOfCreationUniverseToOurDays');
		$(".star5").removeClass('SheWillBeBrightFromDayOfCreationUniverseToOurDays');
		$(".forStarsRating").val("3");	
});

$( ".jsScriptShow4" ).click(function() {
	$(".ValueForStar").text('Well');
// 	    $(".Assesment1").addClass('hide');
// 		$(".Assesment2").addClass('hide');
// 		$(".Assesment3").addClass('hide');
// 		$(".Assesment5").addClass('hide');
// 		$(".Assesment4").removeClass('hide');

		
		alert("Your assesment is Well. 4 point from 5.");
		$(".star1").addClass('SheWillBeBrightFromDayOfCreationUniverseToOurDays');
		$(".star2").addClass('SheWillBeBrightFromDayOfCreationUniverseToOurDays');
		$(".star3").addClass('SheWillBeBrightFromDayOfCreationUniverseToOurDays');
		$(".star4").addClass('SheWillBeBrightFromDayOfCreationUniverseToOurDays');
		$(".star5").removeClass('SheWillBeBrightFromDayOfCreationUniverseToOurDays');
		$(".forStarsRating").val("4");	
});

$( ".jsScriptShow5" ).click(function() {
	$(".ValueForStar").text('VeryWell');
// 	    $(".Assesment1").addClass('hide');
// 		$(".Assesment2").addClass('hide');
// 		$(".Assesment3").addClass('hide');
// 		$(".Assesment4").addClass('hide');
// 		$(".Assesment5").removeClass('hide');

		
		alert("Your assesment is Very Well. 5 point from 5.");
		$(".star1").addClass('SheWillBeBrightFromDayOfCreationUniverseToOurDays');
		$(".star2").addClass('SheWillBeBrightFromDayOfCreationUniverseToOurDays');
		$(".star3").addClass('SheWillBeBrightFromDayOfCreationUniverseToOurDays');
		$(".star4").addClass('SheWillBeBrightFromDayOfCreationUniverseToOurDays');
		$(".star5").addClass('SheWillBeBrightFromDayOfCreationUniverseToOurDays');
		$(".forStarsRating").val("5");	

});





// input[type="radio"]:checked + label {
//     color: green;
// }

$('.jsScriptShow1').hover(
	    function(){ $(".star1").removeClass('showPatric') },
       function(){ $(".star1").addClass('showPatric') }
)

$('.jsScriptShow2').hover(
	    
		function(){ 
			$(".star1").removeClass('showPatric')
	    	$(".star2").removeClass('showPatric')
	    	},
	 
	    function(){ 
	    		$(".star1").addClass('showPatric')
	    		$(".star2").addClass('showPatric')
	    		}   	
)

$('.jsScriptShow3').hover(
	    
		function(){ 
			$(".star1").removeClass('showPatric')
	    	$(".star2").removeClass('showPatric')
	    	$(".star3").removeClass('showPatric')
	    	},
	 
	    function(){ 
	    		$(".star1").addClass('showPatric')
	    		$(".star2").addClass('showPatric')
	    		$(".star3").addClass('showPatric')
	    		}   	
)

$('.jsScriptShow4').hover(
	    
		function(){ 
			$(".star1").removeClass('showPatric')
	    	$(".star2").removeClass('showPatric')
	    	$(".star3").removeClass('showPatric')
	    	$(".star4").removeClass('showPatric')

	    	},
	 
	    function(){ 
	    		$(".star1").addClass('showPatric')
	    		$(".star2").addClass('showPatric')
	    		$(".star3").addClass('showPatric')
	    		$(".star4").addClass('showPatric')

	    		}   	
)


$('.jsScriptShow5').hover(
	    
		function(){ 
			$(".star1").removeClass('showPatric')
	    	$(".star2").removeClass('showPatric')
	    	$(".star3").removeClass('showPatric')
	    	$(".star4").removeClass('showPatric')
	    	$(".star5").removeClass('showPatric')

	    	},
	 
	    function(){ 
	    		$(".star1").addClass('showPatric')
	    		$(".star2").addClass('showPatric')
	    		$(".star3").addClass('showPatric')
	    		$(".star4").addClass('showPatric')
	    		$(".star5").addClass('showPatric')
	    		}   	
)
