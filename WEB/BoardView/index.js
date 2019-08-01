function showAlert() {
  var tagValue = document.getElementById('tag_test');
  alert(tagValue.innerHTML );
  if(tagValue.innerHTML  == "Professional"){
    tagValue.style.background = "yellow";
  }
}
