(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["editMovie"],{"5b89":function(e,r,t){"use strict";t.r(r);var n=t("7a23"),a=Object(n["g"])("h1",null,"Edit Movie",-1),o={key:0,class:"error"},i=Object(n["g"])("label",null,"ERROR: ",-1);function s(e,r,t,s,c,d){var u=Object(n["z"])("MovieForm");return Object(n["r"])(),Object(n["f"])("div",null,[a,c.areErrors?(Object(n["r"])(),Object(n["f"])("div",o,[i,Object(n["g"])("h4",null,Object(n["B"])(c.error),1)])):Object(n["e"])("",!0),Object(n["i"])(u,{edit:c.editData,onSaveMovie:d.saveMovie},null,8,["edit","onSaveMovie"])])}var c=t("1da1"),d=(t("96cf"),t("d3b7"),t("ac1f"),t("5319"),t("a820")),u={components:{MovieForm:d["a"]},props:["id"],data:function(){return{editData:{edit:!0,id:this.id},error:"",areErrors:!1}},methods:{saveMovie:function(e){var r=this;return Object(c["a"])(regeneratorRuntime.mark((function t(){var n,a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,fetch("api/movies/".concat(r.id),{method:"PUT",headers:{"Content-type":"application/json"},body:JSON.stringify(e)});case 2:if(n=t.sent,r.areErrors=r.handleErrors(n),r.areErrors){t.next=8;break}r.$router.replace({name:"MovieDetails",params:{id:r.id}}),t.next=12;break;case 8:return t.next=10,n.json();case 10:a=t.sent,r.error=a.message;case 12:case"end":return t.stop()}}),t)})))()},handleErrors:function(e){return!e.ok}}},v=t("6b0d"),b=t.n(v);const l=b()(u,[["render",s]]);r["default"]=l}}]);
//# sourceMappingURL=editMovie.037943f9.js.map