(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["directors"],{"0b42":function(e,t,r){var n=r("da84"),o=r("e8b5"),c=r("68ee"),i=r("861d"),a=r("b622"),u=a("species"),s=n.Array;e.exports=function(e){var t;return o(e)&&(t=e.constructor,c(t)&&(t===s||o(t.prototype))?t=void 0:i(t)&&(t=t[u],null===t&&(t=void 0))),void 0===t?s:t}},"1dde":function(e,t,r){var n=r("d039"),o=r("b622"),c=r("2d00"),i=o("species");e.exports=function(e){return c>=51||!n((function(){var t=[],r=t.constructor={};return r[i]=function(){return{foo:1}},1!==t[e](Boolean).foo}))}},"2a7d":function(e,t,r){"use strict";var n=r("7a23"),o=["type"];function c(e,t,r,c,i,a){return Object(n["r"])(),Object(n["f"])("button",{class:"btn",type:r.type,onClick:t[0]||(t[0]=function(e){return a.onClick()})},Object(n["B"])(r.title),9,o)}var i={name:"Button",props:{title:String,type:{default:"submit",type:String}},methods:{onClick:function(){this.$emit("btn-click")}},emits:["btn-click"]},a=(r("e07c"),r("6b0d")),u=r.n(a);const s=u()(i,[["render",c],["__scopeId","data-v-6cbfb26a"]]);t["a"]=s},"34a6":function(e,t,r){},"408a":function(e,t,r){var n=r("e330");e.exports=n(1..valueOf)},4169:function(e,t,r){"use strict";var n=r("7a23");function o(e,t,r,o,c,i){var a=Object(n["z"])("Backdrop");return Object(n["r"])(),Object(n["d"])(a,{onOnModal:i.onModal},{default:Object(n["I"])((function(){return[Object(n["g"])("div",{class:"modal",onClick:t[0]||(t[0]=Object(n["K"])((function(){}),["stop"]))},[Object(n["y"])(e.$slots,"default",{},void 0,!0)])]})),_:3},8,["onOnModal"])}function c(e,t,r,o,c,i){return Object(n["r"])(),Object(n["f"])("div",{class:"backdrop",onClick:t[0]||(t[0]=function(){return i.onModal&&i.onModal.apply(i,arguments)})},[Object(n["y"])(e.$slots,"default",{},void 0,!0)])}var i={name:"Backdrop",methods:{onModal:function(){this.$emit("onModal")}},emits:["onModal"]},a=(r("b662"),r("6b0d")),u=r.n(a);const s=u()(i,[["render",c],["__scopeId","data-v-8fe020ca"]]);var d=s,l={name:"Modal",components:{Backdrop:d},props:{},methods:{onModal:function(){this.$emit("onModal")}},emits:["onModal"]};r("c25a");const f=u()(l,[["render",o],["__scopeId","data-v-a5fb2aac"]]);t["a"]=f},"4de4":function(e,t,r){"use strict";var n=r("23e7"),o=r("b727").filter,c=r("1dde"),i=c("filter");n({target:"Array",proto:!0,forced:!i},{filter:function(e){return o(this,e,arguments.length>1?arguments[1]:void 0)}})},"4e39":function(e,t,r){},5899:function(e,t){e.exports="\t\n\v\f\r                　\u2028\u2029\ufeff"},"58a8":function(e,t,r){var n=r("e330"),o=r("1d80"),c=r("577e"),i=r("5899"),a=n("".replace),u="["+i+"]",s=RegExp("^"+u+u+"*"),d=RegExp(u+u+"*$"),l=function(e){return function(t){var r=c(o(t));return 1&e&&(r=a(r,s,"")),2&e&&(r=a(r,d,"")),r}};e.exports={start:l(1),end:l(2),trim:l(3)}},"5e22":function(e,t,r){},"65f0":function(e,t,r){var n=r("0b42");e.exports=function(e,t){return new(n(e))(0===t?0:t)}},"6c36":function(e,t,r){"use strict";r("34a6")},7156:function(e,t,r){var n=r("1626"),o=r("861d"),c=r("d2bb");e.exports=function(e,t,r){var i,a;return c&&n(i=t.constructor)&&i!==r&&o(a=i.prototype)&&a!==r.prototype&&c(e,a),e}},a9e3:function(e,t,r){"use strict";var n=r("83ab"),o=r("da84"),c=r("e330"),i=r("94ca"),a=r("6eeb"),u=r("1a2d"),s=r("7156"),d=r("3a9b"),l=r("d9b5"),f=r("c04e"),b=r("d039"),p=r("241c").f,O=r("06cf").f,j=r("9bf2").f,v=r("408a"),m=r("58a8").trim,h="Number",D=o[h],g=D.prototype,y=o.TypeError,M=c("".slice),N=c("".charCodeAt),I=function(e){var t=f(e,"number");return"bigint"==typeof t?t:k(t)},k=function(e){var t,r,n,o,c,i,a,u,s=f(e,"number");if(l(s))throw y("Cannot convert a Symbol value to a number");if("string"==typeof s&&s.length>2)if(s=m(s),t=N(s,0),43===t||45===t){if(r=N(s,2),88===r||120===r)return NaN}else if(48===t){switch(N(s,1)){case 66:case 98:n=2,o=49;break;case 79:case 111:n=8,o=55;break;default:return+s}for(c=M(s,2),i=c.length,a=0;a<i;a++)if(u=N(c,a),u<48||u>o)return NaN;return parseInt(c,n)}return+s};if(i(h,!D(" 0o1")||!D("0b1")||D("+0x1"))){for(var x,w=function(e){var t=arguments.length<1?0:D(I(e)),r=this;return d(g,r)&&b((function(){v(r)}))?s(Object(t),r,w):t},E=n?p(D):"MAX_VALUE,MIN_VALUE,NaN,NEGATIVE_INFINITY,POSITIVE_INFINITY,EPSILON,MAX_SAFE_INTEGER,MIN_SAFE_INTEGER,isFinite,isInteger,isNaN,isSafeInteger,parseFloat,parseInt,fromString,range".split(","),_=0;E.length>_;_++)u(D,x=E[_])&&!u(w,x)&&j(w,x,O(D,x));w.prototype=g,g.constructor=w,a(o,h,w)}},b662:function(e,t,r){"use strict";r("5e22")},b727:function(e,t,r){var n=r("0366"),o=r("e330"),c=r("44ad"),i=r("7b0b"),a=r("07fa"),u=r("65f0"),s=o([].push),d=function(e){var t=1==e,r=2==e,o=3==e,d=4==e,l=6==e,f=7==e,b=5==e||l;return function(p,O,j,v){for(var m,h,D=i(p),g=c(D),y=n(O,j),M=a(g),N=0,I=v||u,k=t?I(p,M):r||f?I(p,0):void 0;M>N;N++)if((b||N in g)&&(m=g[N],h=y(m,N,D),e))if(t)k[N]=h;else if(h)switch(e){case 3:return!0;case 5:return m;case 6:return N;case 2:s(k,m)}else switch(e){case 4:return!1;case 7:s(k,m)}return l?-1:o||d?d:k}};e.exports={forEach:d(0),map:d(1),filter:d(2),some:d(3),every:d(4),find:d(5),findIndex:d(6),filterReject:d(7)}},bd45:function(e,t,r){},c25a:function(e,t,r){"use strict";r("4e39")},e07c:function(e,t,r){"use strict";r("bd45")},e8b5:function(e,t,r){var n=r("c6b6");e.exports=Array.isArray||function(e){return"Array"==n(e)}},ee05:function(e,t,r){"use strict";r.r(t);var n=r("7a23"),o={class:"flex directors no-align"},c={class:"flex row"},i=Object(n["g"])("h1",null,"Directors",-1);function a(e,t,r,a,u,s){var d=Object(n["z"])("Button"),l=Object(n["z"])("DirectorTable"),f=Object(n["z"])("Modal");return Object(n["r"])(),Object(n["f"])("div",o,[Object(n["g"])("div",c,[i,Object(n["i"])(d,{title:"Add Director",onBtnClick:s.addDirector},null,8,["onBtnClick"])]),Object(n["i"])(l,{directors:u.directors,onOnDelete:s.onDelete},null,8,["directors","onOnDelete"]),u.deleteModalOpen?(Object(n["r"])(),Object(n["d"])(f,{key:0,onOnModal:s.onDeleteModal},{default:Object(n["I"])((function(){return[Object(n["g"])("p",null," Are you sure you want to delete "+Object(n["B"])(u.directorDelete.firstName)+" "+Object(n["B"])(u.directorDelete.lastName)+"? ",1),Object(n["i"])(d,{title:"Delete",onBtnClick:t[0]||(t[0]=function(e){return s.deleteDirector(u.directorDelete.id)})})]})),_:1},8,["onOnModal"])):Object(n["e"])("",!0)])}var u=r("1da1"),s=(r("96cf"),r("d3b7"),r("4de4"),Object(n["g"])("thead",null,[Object(n["g"])("tr",null,[Object(n["g"])("th",{scope:"col"},"#"),Object(n["g"])("th",{scope:"col"},"Name"),Object(n["g"])("th",{scope:"col"})])],-1));function d(e,t,r,o,c,i){var a=Object(n["z"])("Director");return Object(n["r"])(),Object(n["f"])("div",null,[Object(n["g"])("table",null,[s,Object(n["g"])("tbody",null,[(Object(n["r"])(!0),Object(n["f"])(n["a"],null,Object(n["x"])(r.directors,(function(e,t){return Object(n["r"])(),Object(n["f"])("tr",{key:e.id},[Object(n["i"])(a,{director:e,listNumber:++t,onOnDelete:i.onDelete},null,8,["director","listNumber","onOnDelete"])])})),128))])])])}var l={class:"id"},f={class:"name"},b={class:"delete"};function p(e,t,r,o,c,i){var a=Object(n["z"])("router-link");return Object(n["r"])(),Object(n["f"])(n["a"],null,[Object(n["g"])("td",l,Object(n["B"])(r.listNumber),1),Object(n["g"])("td",f,[Object(n["i"])(a,{to:{name:"DirectorDetails",params:{id:r.director.id}}},{default:Object(n["I"])((function(){return[Object(n["h"])(Object(n["B"])(r.director.firstName)+" "+Object(n["B"])(r.director.lastName),1)]})),_:1},8,["to"])]),Object(n["g"])("td",b,[Object(n["g"])("p",{onClick:t[0]||(t[0]=function(e){return i.onDelete(r.director)})},"Delete")])],64)}r("a9e3");var O={name:"Director",props:{director:Object,listNumber:Number},methods:{onDelete:function(e){this.$emit("onDelete",e)}},emits:["onDelete"]},j=(r("6c36"),r("6b0d")),v=r.n(j);const m=v()(O,[["render",p],["__scopeId","data-v-48a88cf0"]]);var h=m,D={name:"DirectorTable",components:{Director:h},props:{directors:Array},methods:{onDelete:function(e){this.$emit("onDelete",e)}},emits:["onDelete"]};const g=v()(D,[["render",d]]);var y=g,M=r("2a7d"),N=r("4169"),I={components:{DirectorTable:y,Button:M["a"],Modal:N["a"]},data:function(){return{directors:[],deleteModalOpen:!1,directorDelete:{}}},methods:{onDelete:function(e){this.directorDelete=e,this.deleteModalOpen=!this.deleteModalOpen},onDeleteModal:function(){this.deleteModalOpen=!this.deleteModalOpen},deleteDirector:function(e){var t=this;return Object(u["a"])(regeneratorRuntime.mark((function r(){return regeneratorRuntime.wrap((function(r){while(1)switch(r.prev=r.next){case 0:return r.next=2,fetch("api/directors/".concat(e),{method:"DELETE",headers:{"Content-type":"application/json"}});case 2:t.directors=t.directors.filter((function(t){return t.id!==e})),t.directorDelete=null,t.deleteModalOpen=!t.deleteModalOpen;case 5:case"end":return r.stop()}}),r)})))()},fetchDirectors:function(){return Object(u["a"])(regeneratorRuntime.mark((function e(){var t,r;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,fetch("api/directors");case 2:return t=e.sent,e.next=5,t.json();case 5:return r=e.sent,e.abrupt("return",r);case 7:case"end":return e.stop()}}),e)})))()},addDirector:function(){this.$router.push({name:"AddDirector"})}},created:function(){var e=this;return Object(u["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,e.fetchDirectors();case 2:e.directors=t.sent;case 3:case"end":return t.stop()}}),t)})))()}};const k=v()(I,[["render",a]]);t["default"]=k}}]);
//# sourceMappingURL=directors.f2b11fec.js.map