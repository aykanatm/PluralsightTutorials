Vue.config.keyCodes.f2 = 113;

const growler = new Vue({
    el: '#growler',
    data:{
        appName: 'Growler',
        query: '',
        isRunning: false,
        showContextMenu: false,
        top: '0px',
        left: '0px'
    },
    methods:{
        // event is an optional parameter
        executeSearch:function(event){
            // In a method "this" keyword is automatically bound to the vue instance (It is like running "growler.query")
            console.log('Search executed with the query "' + this.query + '"');
            console.log(event);
        },
        executeSearchTwo:function(t, e){
            // In a method "this" keyword is automatically bound to the vue instance (It is like running "growler.query")
            console.log('Search executed with the query "' + this.query + '"');
            console.log('Token: ' + t);
            console.log(e);
        },
        grandParentClick: function(){
            console.log('Grand parent click.');
        },
        parentClick:function(){
            console.log('Parent click.');
        },
        executeSearchThree:function(){
            if(this.query){
                document.forms[4].submit();
            }
            else{
                console.log('Please enter a query');
            }
        },
        executeSearchFour:function(){
            this.isRunning = true;
            document.forms[9].submit();
        },
        executeSearchFive:function(){
            this.isRunning = true;
            document.forms[9].submit();
        },
        evaluateKey:function(){
            console.log('Evaluating key...');
        },
        openInfo:function(){
            console.log('Help');
        },
        onBlockClick:function(){
            console.log('Click.');
        },
        onCopyClick:function(){
            console.log('Copy click.');
        },
        onPasteClick:function(){
            console.log('Paste click.');
        },
        openContextMenu:function(e){
            console.log('Opening context menu...');
            this.showContextMenu = true;
            this.top = e.y + 'px';
            this.left = e.x + 'px';            
        },
        closeContextMenu:function(){
            this.showContextMenu = false;
        },
        executeSearchInNewWindow:function(){
            console.log('Search in a new window');
        }
    },        
});

