//declaring and defining functions

function f1(){
    console.log("function with no params and no return");    
}

function f2(userName="Tom Hanks"){
    console.log("function with params and no return");    
    console.log("received " + userName);
}
            
function f3(userName="Tony Stark"){
    console.log("function with params and return");    
    console.log("received " + userName);
    return "Hello " + userName;
}

//call them
f1();
f2("Carly Rae Jepsen");
f3();
//console.log(f3("Voldemort"));