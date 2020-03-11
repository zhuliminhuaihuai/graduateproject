//数字时间转DATE时间类型
function editTime(v){
    var date = new Date(v);
    var y = date.getFullYear();
    var m = date.getMonth()+1;
    m = m<10?'0'+m:m;
    var d = date.getDate();
    d = d<10?("0"+d):d;
    var h = date.getHours();
    h = h<10?("0"+h):h;
    var M = date.getMinutes();
    M = M<10?("0"+M):M;
    var S = date.getSeconds();
    S = S<10?("0"+S):S;
    var str = y+"-"+m+"-"+d+" "+h+":"+M+":"+S;
    return str;
}

function fixed(str) {
    if (!str) str = '0.00';
    var ret = Math.round(parseFloat(str) * 100) / 100;
    var decimal = ret.toString().split('.');
    if (decimal.length === 1) {
        return ret.toString() + '.00'
    };
    if (decimal.length > 1) {
        if (decimal[1].length < 2) {
            return ret.toString() + '0'
        }
        return ret
    };
    return ret;
}
function mulStr(str) {
   var s = str *100;
   return s;
}