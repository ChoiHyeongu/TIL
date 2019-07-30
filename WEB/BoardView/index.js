var hw = document.getElementById('view_button');
hw.addEventListener('click', function(){
    alert('Hello world');
})

function getTagBackgrounColor(){
  alert("Onclick");
  var tagText = document.getElementsByClassName('tag').value;
  if(tagText == "Professional"){
    alert("Professional");
  }
}
