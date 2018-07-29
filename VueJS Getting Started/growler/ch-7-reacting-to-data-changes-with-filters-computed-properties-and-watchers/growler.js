const growler = new Vue({
    el: '#growler',
    data:{
        appName: 'Growler',
        beers:[
            {name: 'Tikibalang Barley Wine', price: 9.67, ibu: '33 i.b.u'},
            {name: 'Hylote Chocolate Stout', price: 7.42, ibu: '45 i.b.u' },
            {name: 'Pope Lick Porter', price: 6.53, ibu: '37 i.b.u'},
            {name: 'Ahool Ale', price: 5.45, ibu: '23 i.b.u'},
            {name: 'North Adjule Lager', price: 3.77, ibu: '55 i.b.u'},
            {name: 'North Adjule Lager', price: 3.77, ibu: ''}
        ],
        shoppingCart:{
            items:[],
            subTotal: 0.00
        },                
        // shoppingCart:[],
        // subTotal: 0.00
        canConnect: false        
    },
    computed:{
        isOnline:{
            get:function(){
                return this.canConnect ? 'Yes' : 'No';
            },
            set:function(newValue){
                this.canConnect = newValue;
            }
        }
    },
    created:function(){
        axios.get('https://www.google.com')
            .then(function(res){
                growler.canConnect = true;
            })
            .catch(function(err){
                growler.canConnect = false;
            });
    },
    watch:{
        shoppingCart: {
            handler: function(latest, original){
                this.updateSubTotal();
            },
            // When this is set to true then the changes inside shoppingCart will also trigger the handler function
            deep: true
        },
        // shoppingCart:function(){
        //     this.updateSubTotal();
        // }
    },
    filters:{
        convertIBU:function(value, empty){
            if(!value){
                return empty;
            }

            // value = value.toString();
            // value = value.replace(/\./g, '');
            // return value.toUpperCase();           
            
            return value.toString();
        },
        removePeriods:function(value){
            return value.replace(/\./g, '');
        },
        toUpperCase:function(value){
            return value.toUpperCase();
        }
    },
    methods:{
        buy:function(beer){
            this.shoppingCart.items.push(beer);
        },
        updateSubTotal:function(){
            var s = this.shoppingCart.items.length;
            var t = 0;
            for(var i = 0; i < s; i++){
                t += this.shoppingCart.items[i].price;
            }
            this.shoppingCart.subTotal = t;
        },
        // buy:function(beer){
        //     this.shoppingCart.push(beer);
        // },
        // updateSubTotal:function(){
        //     var s = this.shoppingCart.length;
        //     var t = 0;
        //     for(var i = 0; i < s; i++){
        //         t += this.shoppingCart[i].price;
        //     }
        //     this.subTotal = t;
        // }
    }
});