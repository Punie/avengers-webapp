var initAvengers = function(Monscope, Monhttp) {
    console.log('initAvengers()');

    var url = 'http://172.28.10.229:8080/api/avengers/';
    Monhttp.get(url).then(function(resp) {
        Monscope.avengers = resp.data;
        Monscope.avenger = {};
    });

};

var deleteAvenger = function(id, Monhttp, Monscope) {
    var url = 'http://172.28.10.229:8080/api/avengers/'+id;
    Monhttp.delete(url).then(function() {
        initAvengers(Monscope, Monhttp);
    });
};

var getAvenger = function(id, Monscope, Monhttp) {
    console.log('init()');
    var url = 'http://172.28.10.229:8080/api/avengers/'+id;
    console.log(url);
    Monhttp.get(url).then(function(resp) {
        console.log(resp.data);
        Monscope.av = resp.data;
        resp.data !== null ?  Monscope.maVar = 1 : Monscope.maVar = 0;
    });
};

var saveAvenger = function(Monscope, Monhttp) {
    var url = 'http://172.28.10.229:8080/api/avengers/';
    Monhttp.post(url,Monscope.avenger).then(function() {
        initAvengers(Monscope,Monhttp);
    });
};
