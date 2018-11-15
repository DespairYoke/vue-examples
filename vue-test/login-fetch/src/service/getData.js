import Axios from "axios";

export const shopList = ()=>{
   Axios.post('http://localhost:8090/user', {
       
   })
   .then(function (response){
    console.log(respose)
   })
   .catch(function (error){

   })
}
export const getUser = ()=>{

}
