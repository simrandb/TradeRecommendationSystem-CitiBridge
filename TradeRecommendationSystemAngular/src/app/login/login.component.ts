import { Component, OnInit } from '@angular/core';
import {LoginService} from '../login.service'
import {Router} from '@angular/router'; 
import { Observable } from 'rxjs';
import {Location} from '@angular/common';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  _router: any;

  constructor(private service: LoginService, private router: Router) { }
  

  userVerified:boolean;

  public s(username:Text, password: Text)
  {
  
    console.log("yayy  login.service.ts yayyy")

    
    this.service.verifyUser(username, password).subscribe(response=>{this.userVerified=response})
    console.log(" after verify")
    console.log(this.userVerified)

 //   this.userVerified=true
    
    if(this.userVerified==true)
    {
      window.location.pathname='./home'

      /*
      //Go to dahsboard
      console.log(" inside if")
      //window.location.pathname='./recom'
      window.history.back();
    */
    }
    else if(this.userVerified==false)
    {
      //Stay on login and indicate user invalid credentials
      window.location.pathname='./login'
    
    }
    console.log(" after if else")
  }
  ngOnInit(): void {
  }


}
