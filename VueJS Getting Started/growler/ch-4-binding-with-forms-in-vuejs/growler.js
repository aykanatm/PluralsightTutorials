const growler = new Vue({
    el: '#growler',
    data:{
        appName: 'Growler',
        query: '',
        emailMessage: '',
        isPowerSyntaxEnabled: true,
        searchIndexes: [],
        searchIndex: 'beers',
        selectedSearchIndex: 'beers',
        selectedSearchIndexes:[
            'beers',
            'pubs'
        ],
        result: ''
    }
});