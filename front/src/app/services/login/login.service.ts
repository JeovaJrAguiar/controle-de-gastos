import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Account } from '../../entities/account.model';
import { catchError, tap, throwError } from 'rxjs';
import { StorageService } from '../storage/storage.service';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private API_USER_LOGIN: string = 'http://localhost:8080/api/account/login';

  constructor(
    private http: HttpClient,
    private localStorage: StorageService
  ) { }

  login(mail: string, password:string) {
    const headers = {
      Authorization: 'Basic ' + btoa(mail + ':' + password)
    };

    return this.http.get(this.API_USER_LOGIN, { headers, responseType: 'text' }).pipe(
      tap(response => {
        this.localStorage.set('authorization', btoa(mail + ':' + password));
        return response;
      }),
      catchError(error => {
        console.error('Erro ao fazer login:', error);
        return throwError(error);
      })
    );
  }

  logout() {
    this.localStorage.remove('authorization');
    //this.localStorage.set('authorization', btoa(mail + ':' + password));
  }
}
