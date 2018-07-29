const growler = new Vue({
    el: '#growler',
    data:{
        appName: 'Growler',
        isShowing: true,
        beers:[
            {name: 'Tikibalang Barley Wine', abv: 9.6},
            {name: 'Hylote Chocolate Stout', abv: 7.4},
            {name: 'Pope Lick Porter', abv: 6.5},
            {name: 'Ahool Ale', abv: 5.4},
            {name: 'North Adjule Lager', abv: 3.7}
        ],
        maxAbv: 7.0,
        currentUser:{
            name: 'Murat',
            lastname: 'Aykanat'            
        },
        pages:[
            { number: 1, url: '?page=1'},
            { number: 2, url: '?page=2'},
            { number: 3, url: '?page=3'}
        ],
        beerNames:[
            'Tikibalang Barley Wine',
            'Hylote Chocolate Stout',
            'Pope Lick Porter',
            'Ahool Ale',
            'North Adjule Lager'
        ],
        abvValues:[
            9.6,
            7.4,
            6.5,
            5.4,
            3.7
        ]        
    }
});

// Edits the 3rd item in beerNames array and updates the view
// Vue.set(growler.beerNames, 2, 'Ahool Pale Ale');