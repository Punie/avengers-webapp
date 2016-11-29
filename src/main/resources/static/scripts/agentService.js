var initAgents = function(Monscope, Monhttp) {
    console.log('initAgents()');

    var url = 'http://172.28.10.229:8080/api/agents/';
    Monhttp.get(url).then(function(resp) {
        Monscope.agents = resp.data;
        Monscope.agent = {};
    });

};

var deleteAgent = function(id, Monhttp, Monscope) {
    var url = 'http://172.28.10.229:8080/api/agents/'+id;
    Monhttp.delete(url).then(function() {
        initAgents(Monscope, Monhttp);
    });
};

var getAgent = function(id, Monscope, Monhttp) {
    console.log('init()');
    var url = 'http://172.28.10.229:8080/api/agents/'+id;
    console.log(url);
    Monhttp.get(url).then(function(resp) {
        console.log(resp.data);
        Monscope.ag = resp.data;
        resp.data !== null ?  Monscope.maVar = 1 : Monscope.maVar = 0;
    });
};

var saveAgent = function(Monscope, Monhttp) {
    var url = 'http://172.28.10.229:8080/api/agents/';
    Monhttp.post(url,Monscope.agent).then(function() {
        initAgents(Monscope,Monhttp);
    });
};
