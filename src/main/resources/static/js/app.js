const app = new Vue({
    el: "#app",
    data: {
        items: [],
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
        }
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
        }
        ,
        openputin: function () {
            app.box.itemcheck = false;
            app.box.stockcheck = false;
            app.box.putin = true;
            app.box.putout = false;
        }
        ,
        openputout: function () {
            app.box.itemcheck = false;
            app.box.stockcheck = false;
            app.box.putin = false;
            app.box.putout = true;
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
