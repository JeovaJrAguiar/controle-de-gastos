import { Component } from '@angular/core';
import { LoginService } from '../../services/login/login.service';
import { StorageService } from '../../services/storage/storage.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  username: string = '';
  password: string = '';
  loginFailMessage: string = '';
  mail: string = '';

  //loginService: LoginService = new LoginService();
  constructor(
    private loginService: LoginService,
    private router: Router,
    ) { }

  ngOnInit(): void {
  }

  login(){
    if (!this.password || !this.mail){
        this.loginFailMessage = 'Preencha todos os campos';
        console.log('Preencha todos os campos')
        this.router.navigate(['/login']);
    }

    this.loginService.login(this.mail, this.password).subscribe((response) => {
      if(response){
        console.log('Sucesso no login')
        this.router.navigate(['/home']);
      }else {
        console.log('Erro no login')
        this.loginFailMessage = "Erro. Usuario ou senha não cadastrado.";
        this.router.navigate(['/login']);
      }
    }, (error) => {
      console.log('Excessão no login')
      this.loginFailMessage = "Erro. Usuario ou senha não cadastrado.";
    });
  }

  logout(){
    this.loginService.logout();
  }
}
