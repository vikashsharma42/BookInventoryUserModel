function matchPassword()
{
    if(document.getElementById('cpassword').value!=document.getElementById('password').value)
    {
	  alert("Confirm password does not match with password")
	  return false;
    }
    return true;
}
function setMaxValue()
{
	  document.getElementById("quantity").max=document.getElementById("aq").value;
}
function findCost()
{ 
	var total=document.getElementById("price").innerHTML*document.getElementById("quantity").value;
    document.getElementById("cost").innerHTML=total;
}
 function totalCost(i)
 {
    document.getElementById("costt"+i).innerHTML=document.getElementById(i).value*document.getElementById("price"+i).innerHTML; 
    document.getElementById("tcost").innerHTML=parseInt(document.getElementById("tcost").innerHTML)+parseInt(document.getElementById("price"+i).innerHTML);
    document.getElementById("tobepaid").value=document.getElementById("tcost").innerHTML;
 }
 function checkQuantity()
 {
     var rquantity=parseInt(document.getElementById("quantity").value);
     var totalquantity=parseInt(document.getElementById("aq").innerHTML);
	 if(rquantity>totalquantity)
	 {
		 alert("Quantity can not be more than availabe quantity");
		 document.getElementById("quantity").value=1;
	 }
	 
     else if(rquantity<1)
	 {
		 alert("Quantity can not be negative value");
		 document.getElementById("quantity").value=1;
	 } 
}
 function mark(cb)
 {
	 if(cb.checked && c==4){
		 alert("Maximum 4 allowed at a time")
		 cb.checked=false;
		 return;
	 }
		 
	 if(cb.checked)
		 c++;
	 else
		 c--;
	 if(c==1){
		 document.getElementById("oc").disabled=false;
		 document.getElementById("rc").disabled=false;
	 }
	 else if(c==0){
		 document.getElementById("oc").disabled=true;
		 document.getElementById("rc").disabled=true; 
	 }
 }
 function allowDigits(e,t,n)
 {
	 return ((e.charCode>=48 && e.charCode<=57) && t.value.length<n);
 }
 function checkOtp()
 {
	if(document.getElementById("gotp").innerHTML!=document.getElementById("eotp").value)
	{
		alert("Enter correct OTP");
		return false;
	}
	return true;
 }
 function checkDate()
 {
	 if(document.getElementById("fr").value>document.getElementById("to").value)
	 {
		alert("From date can not be greater than to date");
		return false;
	 }
	 return true;
 }
