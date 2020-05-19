

    function confirm(){

        var e = document.getElementsByName("permission");

        for(i = 0; i < e.length; i++){
            if(!e[i].checked){
                alert("약관을 모두 동의하셔야합니다");
                e[i].focus();
                return false;
            }
        }

        return true;
    }

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



