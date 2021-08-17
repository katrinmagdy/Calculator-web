<template>
   <div class="calculator">
   
  <div id="in2" type="text" class="calculator-screen" value="" disabled >{{exp}}</div>
  <div id="in1" type="text" class="calculator-screen" value="0" disabled >{{y}}</div>

  <div class="calculator-keys">

    <button v-on:click="othoperations('c')" type="button" class="operator" value="%">&percnt;</button>
    <button v-on:click="y=0,x=0,exp='',op='' ">CE</button>
    <button v-on:click="y=0, x=0 ,exp='',op=''">C</button>
    <button v-on:click="del()">&#9003;</button>

    <button v-on:click="othoperations('i')" type="button" class="operator" value="1/x">1/x</button>
    <button v-on:click="othoperations('p')" type="button" class="operator" value="x^2">x&#178;</button>
    <button v-on:click="othoperations('s')" type="button" class="operator" value="root">&#178;&#8730;x</button>
    <button v-on:click="expression('/')" type="button" class="operator" value="/">&divide;</button>

    <button v-on:click="put(7)" >7</button>
    <button v-on:click="put(8)">8</button>
    <button v-on:click="put(9)">9</button>
    <button v-on:click="expression('*')" type="button" class="operator" value="*">&times;</button>

    <button v-on:click="put(4)">4</button>
    <button v-on:click="put(5)">5</button>
    <button v-on:click="put(6)">6</button>
    <button v-on:click="expression('-')" type="button" class="operator" value="-">-</button>

    <button v-on:click="put(1)">1</button>
    <button v-on:click="put(2)">2</button>
    <button v-on:click="put(3)">3</button>
    <button v-on:click="expression('+')" type="button" class="operator" value="+">+</button>
    
    
    <button v-on:click="othoperations('n')" type="button" class="operator" value="negate">-/+</button>
    <button v-on:click="put(0)">0</button>
    <button v-on:click="put('.')">.</button>
    <button v-on:click="equal()" type="button" class="equal-sign" value="=">=</button>


  </div>
  
</div>
</template>

<script>
import  axios  from 'axios'
export default {
  
      name:"calculator",
      data() {
          return {
            exp:"",
            x: 0 ,
            y: 0 ,
            op:'',
       };

      },


     methods: {
    put(number) {
      if (this.y == 0 ) {
        this.y=''+number;
      }
      else if(this.x==0 && this.op!=''){
        this.y=''+number;
        this.op='';
      }
      else{
        if(this.y!="E"){
          this.y=''+this.y+number;
        }
      }   
    },
    del(){
      this.y = this.y.substring(0,this.y.length-1);
     if (this.y === '') {
        this.y=0;
      }
    },
    expression(ope){
      if(this.op!=''&& this.op!='c'&&this.op!='i'&&this.op!='s'&&this.op!='p'&&this.op!='n'&&this.op!='d'){
        var x1 = this.x;
        var y1 = this.y;
        var op1 = this.op;
        axios.get("http://localhost:8085/eval",{
          params : {
            xx : x1 ,
            yy : y1 ,
            operator : op1,
          }
        }).then(response=>{
          this.y=''+response.data;
          if(this.y!="E"){
            this.op=ope;
          var z =this.y;
          this.x=z;
          this.exp=this.x+ope;
          this.y=0;
          }
          else{
            this.op='';
        this.x=0;
        this.exp="";
          }
        })
      }
      else{
        this.op=ope;
      var z =this.y;
      this.x=z;
      this.exp=this.x+ope;
      this.y=0;
      }
    },

    equal(){
      if(this.op!=''&&this.x!=0){
         var x1 = this.x;
        var y1 = this.y;
        var op1 = this.op;
        axios.get("http://localhost:8085/eval",{
          params : {
            xx : x1 ,
            yy : y1 ,
            operator : op1,
          }
        }).then(response=>{
          this.y=''+response.data;
        })
        this.op='d';
        this.x=0;
        this.exp="";
      }   
    },

    othoperations(o){
      var x1 , y1,op1 ;
      if(o=='c'){
         x1 = this.x;
         y1 = this.y;
         op1 = o;
        axios.get("http://localhost:8085/eval",{
          params : {
            xx : x1 ,
            yy : y1 ,
            operator : op1,
          }
        }).then(response=>{
          this.y=response.data;
           x1 = this.x;
           y1 = this.y;
           op1 = this.op;
        axios.get("http://localhost:8085/eval",{
          params : {
            xx : x1 ,
            yy : y1 ,
            operator : op1,
          }
        }).then(response=>{
          this.y=''+response.data;
          this.op='c';
          this.x=0;
        this.exp="";
        })
        })
      }
      else{
        this.op=o;
         x1 = this.x;
         y1 = this.y;
         op1 = o;
        axios.get("http://localhost:8085/eval",{
          params : {
            xx : x1 ,
            yy : y1 ,
            operator : op1,
          }
        }).then(response=>{
          this.y=''+response.data;
        })
      }   
    },
     },  
  }
</script>

<style>
html {
  font-size: 62.5%;
  box-sizing: border-box;
}
*, *::before, *::after {
  margin: 0;
  padding: 0;
  box-sizing: inherit;
}
.calculator {
  border: 1px solid #ccc;
  border-radius: 5px;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 400px;
}
.calculator-screen {
  width: 100%;
  font-size: 5rem;
  height: 80px;
  border: none;
  background-color: #252525;
  color: #fff;
  text-align: right;
  padding-right: 20px;
  padding-left: 10px;
}
button {
  height: 60px;
  background-color: #fff;
  border-radius: 3px;
  border: 1px solid #c4c4c4;
  background-color: transparent;
  font-size: 2rem;
  color: #333;
  background-image: linear-gradient(to bottom,transparent,transparent 50%,rgba(0,0,0,.04));
  box-shadow: inset 0 0 0 1px rgba(255,255,255,.05), inset 0 1px 0 0 rgba(255,255,255,.45), inset 0 -1px 0 0 rgba(255,255,255,.15), 0 1px 0 0 rgba(255,255,255,.15);
  text-shadow: 0 1px rgba(255,255,255,.4);
}
button:hover {
  background-color: #eaeaea;
}
.operator {
  color: #337cac;
}
.equal-sign {
  background-color: #2e86c0;
  border-color: #337cac;
  color: #fff;
}
.equal-sign:hover {
  background-color: #4e9ed4;
}
.calculator-keys {
  display: grid;
}
.calculator-keys {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
}

</style>