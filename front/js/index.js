const access = document.getElementById('Access');
if(access){
    access.addEventListener('click', function(){
        window.location.href = 'log_in.html';
    });
}

document.getElementById('LogAsGuest').onclick = function() {
    window.location.href = 'dashboard.html';
}
document.getElementById('Access').onclick = function() {
    window.location.href = 'log_in.html';
}