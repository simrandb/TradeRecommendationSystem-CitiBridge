import { Component, OnInit } from '@angular/core';
import {LoginService} from '../login.service'
import {Router} from '@angular/router'; 

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  constructor(private service: LoginService, private router: Router) { }
  

   userVerified:boolean

  public s(username:Text, password: Text)
  {
    console.log("yayy  login.service.ts yayyy")

    this.service.verifyUser(username, password).subscribe(response=>{this.userVerified=response})
    if(this.userVerified==true)
    {
      //Go to dahsboard
    }
    else
    {
      //Stay on login and indicate user invalid credentials
    }

  
  }
  ngOnInit(): void {
  }


}
