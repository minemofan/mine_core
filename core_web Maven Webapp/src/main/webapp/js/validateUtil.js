/**
 * Description:
 * 			1、validateIpAddr(tid)根据传入的input id 验证ip地址是否有效。
 * 			
 * @author mosh
 * 
 */
function validateIpAddr(tid){
        var ip = $("#"+tid).val();
        var val = /([0-9]{1,3}\.{1}){3}[0-9]{1,3}/;
        var vald = val.exec(ip);
        if (vald == null) {
            alert('无效的ip地址！');
            $("#ip").val("").focus();
            return false;
        }
        if (vald != '') {
            if (vald[0] != ip) {
                alert('无效的ip地址！');
                $("#ip").val("").focus();
                return false;
            }
        }
        return true;
    }