function _PnUtils(){

    this.deletePn = function(id){
        if(confirm("Are you sure?")){
            window.location = "/deleteProduct/" + id;
        }
    }
}

function _ContactUtils(){

    this.deleteContact = function(id){
        if(confirm("Are you sure?")){
            window.location = "/deleteContact/" + id;
        }
    }
}

var PnUtils = new _PnUtils();
var ContactUtils = new _ContactUtils();