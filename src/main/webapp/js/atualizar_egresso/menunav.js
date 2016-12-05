$(document).ready(function(){

    var pageName = window.location.pathname.split("/").pop();

    $('a[href="' + pageName + '"] > span').removeClass("label-default").addClass("label-primary");

});
