import axios from 'axios';
const baseUrl='http://localhost:8081/tweets';
class UserService{
	
	saveUser(user){
		return axios.post(baseUrl+'/register',user);
	}
getLogin(loginId,password){
	
	var basicAuth = 'Basic ' + window.btoa(loginId + ':' + password);
	console.log(basicAuth);
	console.log(axios.get(baseUrl+'/login',{headers: { 'Authorization': basicAuth }}));
	return axios.get(baseUrl+'/login',{headers: { 'Authorization': basicAuth }});
}
  getUser(){
	return axios.get(baseUrl+'/users/all');
   }
   getUserSearch(username){
	return axios.get(baseUrl+'/user/search/'+username);
   }
   forgetPassword(username,newPassword){
  	let loginId=localStorage.getItem('loginId');
		return axios.put(baseUrl+'/'+username+'/forgetPassword/'+newPassword);
	}
	
}
export default new UserService()