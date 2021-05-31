import { Component, OnInit } from '@angular/core';
import {LoginService} from '../login.service'
import {Router} from '@angular/router'; 
import { Observable } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  _router: any;
  constructor(private service: LoginService, private router: Router) {
    
   }

  public s(username:Text, password: Text)
  {
  
    console.log("yayy  s yayyy")
    this.service.verifyUserExist(username).subscribe(response=>{ this.UserVerification(response, username, password)})
    console.log(" after verify")
    
  }
  private UserVerification(res:boolean, uname:Text, pwd:Text){
    console.log("yayy  UserVerification yayyy")
    if(res==true)
    {
      console.log("yayy  UserVerification true yayyy")
      this.service.verifyUser(uname, pwd).subscribe(response=>{ this.validate(response, uname)})
    }
    else
    {
      console.log("yayy  UserVerification false yayyy")
      alert('USER DOES NOT EXIST IN DATABASE!')
      window.location.pathname='./login'
    }
  }
  private validate(val:boolean, username:Text){
    console.log("in validate "+val)
    if(val==true)
    {
      //Go to dashboard
      console.log(" inside if")
      alert('LOGGED IN SUCCESSFULLY! Refreshing db')
      localStorage.setItem('username', username.toString())
      console.log(localStorage.getItem('username'))
      window.location.pathname='./profile'
    }
    else
    {
      //Stay on login and indicate user invalid credentials
      alert('ENTER CORRECT PASSWORD!')
      window.location.pathname='./login'
    }

  }
  
  ngOnInit(): void {
      
  }


}
