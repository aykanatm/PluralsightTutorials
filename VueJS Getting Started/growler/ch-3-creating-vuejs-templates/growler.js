const growler = new Vue({
    el: '#growler',
    data:{
        appName: 'Growler',
        htmlData: '<a href="">Some link</a>',
        appLogo: 'img/logo.png',
        // Styling
        // We can use seperate fields
        color: '#FF6A00',
        fontFamily: 'Arial',
        // Or a JS object
        appStyle:{
            color: '#FF6A00',
            fontFamily: 'Verdana'
        },
        // Or multiple objects for various styling
        accentColor:{
            color: '#FF6A00'
        },
        headers:{
            fontFamily: 'Verdana',
        },
        // Or bind to CSS classes
        cssAccentColor: 'accent-color',
        cssHeaders: 'headers',
        headerClasses:[
            'accent-color', 'headers'
        ],
        isOnline: false
    }
});