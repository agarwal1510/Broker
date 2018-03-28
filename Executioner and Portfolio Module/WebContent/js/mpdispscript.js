function DispMp() {
	document.getElementById("mp").style.display = "inline";
	document.getElementById("mp").style.visibility = 'visible';
}
function DispLp() {
	document.getElementById("lp").style.display = "inline";
	document.getElementById("lp").style.visibility = 'visible';
}
function DispSp() {
	document.getElementById("sp").style.display = "inline";
	document.getElementById("sp").style.visibility = 'visible';
}
function DispLsp() {
	document.getElementById("lp").style.display = "inline";
	document.getElementById("lp").style.visibility = 'visible';
	document.getElementById("sp").style.display = "inline";
	document.getElementById("sp").style.visibility = 'visible';
	
}

function hideAll(){
	document.getElementById("mp").style.visibility = 'hidden';
	document.getElementById("mp").style.display = 'none';
	document.getElementById("lp").style.visibility = 'hidden';
	document.getElementById("lp").style.display = 'none';
	document.getElementById("sp").style.visibility = 'hidden';
	document.getElementById("sp").style.display = 'none';
}

function display(sel){
	hideAll();
	
	if(sel.value=="marketprice"){
		DispMp();

	}else if(sel.value=="limitprice"){
		DispLp();

	}else if(sel.value=="stopprice"){
		DispSp();

	}else if(sel.value=="limitstop"){
		DispLsp();

	}
}