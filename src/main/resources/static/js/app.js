const app = new Vue({
    el: "#app",
    data: {
        queryutil:{
            year:null,
            month:null,
            day:null,
            type:0
        },
        putinadditem: {},
        putoutadditem: {},
        items: [],
        itemmap: [],
        additem: {
            id: null,
            itemname: null,
            itemprice: null,
            number: null,
            createtime: null,
            createuser: null
        },
        uppitem: {
            id: null,
            itemname: null,
            itemprice: null,
            number: null,
            createtime: null,
            createuser: null
        },
        box: {
            itemcheck: false,
            stockcheck:
                false,
            putin:
                false,
            putout:
                false,
        },
        ruku: [],
        chuku: [],
        temp: [],
    },
    methods: {
        additems: function () {
            axios.post('/items/additem', app.additem).then((res) => {
                app.items.push(res.data);
            }).catch((error) => {
                alert(eroor);
            })
        },
        updateitem: function (id) {
            const temp = {id: id}
            axios.post("/items/queryById", temp).then((res) => {
                app.uppitem = res.data;
            }).catch((error) => {
                alert(error);
            });
        },

        update: function () {
            axios.post("/items/update", app.uppitem).then((res) => {
                app.items = app.items.filter((element, index, array) => {
                    return array[index].id !== app.uppitem.id;
                });
                app.items.push(res.data);
            }).catch((error) => {
                alert(error);
            });
        },

        deleteitem: function (id) {
            const temp = {id: id};
            axios.post("/items/deleteById", temp).then((res) => {
                app.items = app.items.filter((element, index, array) => {
                    return array[index].id !== id;
                });
            }).catch((error) => {
                alert(error);
            });
        },

        openitem: function () {
            axios.post('/items/queryListForPage').then((res) => {
                for (index in res.data) {
                    res.data[index].createtime = fmtDate(res.data[index].createtime);
                }
                app.items = res.data;
            }).catch((error) => {
                alert(error);
            });
            app.box.itemcheck = true;
            app.box.stockcheck = false;
            app.box.putin = false;
            app.box.putout = false;
        }
        ,
        openstock: function () {
            app.box.itemcheck = false;
            app.box.stockcheck = true;
            app.box.putin = false;
            app.box.putout = false;

            axios.post("/record/queryAllRecord").then((res)=>{
                console.log(res.data);
            })
        }
        ,
        openputin: function () {
            app.box.itemcheck = false;
            app.box.stockcheck = false;
            app.box.putin = true;
            app.box.putout = false;

            axios.post("/record/queryRuKu").then((response) => {
                for (index in response.data) {
                    response.data[index].time = fmtDate(response.data[index].time);
                }

                response.data.forEach((a) => {
                    app.itemmap.forEach((b) => {
                        if (a.item_id == b.id) {
                            a.item_id = b.itemname;
                        }
                    })
                })

                app.ruku = response.data;
            }).catch((error) => {
                console.log(error);
            });

            axios.post("/record/queryMap").then((res) => {
                app.itemmap = res.data;
            });
        },
        putinadd: function () {
            app.itemmap.forEach((a) => {
                if (a.itemname == app.putinadditem.item_id) {
                    app.putinadditem.item_id = a.id;
                }
            })
            axios.post("/record/rukuadd", app.putinadditem).then((res) => {
                app.itemmap.forEach((a) => {
                    if (a.id == res.data.item_id) {
                        res.data.item_id = a.itemname;
                        res.data.time = fmtDate(res.data.time);
                    }
                });
                app.ruku.push(res.data);
            });

            app.putinadditem = [];
        }
        ,
        openputout: function () {
            app.box.itemcheck = false;
            app.box.stockcheck = false;
            app.box.putin = false;
            app.box.putout = true;

            axios.post("/record/queryChuKu").then((response) => {
                for (index in response.data) {
                    response.data[index].time = fmtDate(response.data[index].time);
                }

                response.data.forEach((a) => {
                    app.itemmap.forEach((b) => {
                        if (a.item_id == b.id) {
                            a.item_id = b.itemname;
                        }
                    })
                })

                app.chuku = response.data;
            }).catch((error) => {
                console.log(error);
            });
            axios.post("/record/queryMap").then((res) => {
                app.itemmap = res.data;
            });

        },
        putoutadd: function () {
            app.itemmap.forEach((a) => {
                if (a.itemname == app.putoutadditem.item_id) {
                    app.putoutadditem.item_id = a.id;
                }
            })
            axios.post("/record/chukuadd", app.putoutadditem).then((res) => {
                if (res.data.id == "0"){
                    alert("你没有那么多货了");
                }else{
                    app.itemmap.forEach((a) => {
                        if (a.id == res.data.item_id) {
                            res.data.item_id = a.itemname;
                            res.data.time = fmtDate(res.data.time);
                        }
                    });
                    app.chuku.push(res.data);
                }
            });
            app.putoutadditem = [];
        },
        checkitem:function () {
            axios.post("/record/queryAllRecord",app.queryutil);
        }
    }
});

function fmtDate(obj) {
    var date = new Date(obj);
    var y = 1900 + date.getYear();
    var m = "0" + (date.getMonth() + 1);
    var d = "0" + date.getDate();
    return y + "-" + m.substring(m.length - 2, m.length) + "-" + d.substring(d.length - 2, d.length);
}
