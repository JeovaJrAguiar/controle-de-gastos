import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { StorageService } from '../storage/storage.service';
import { catchError, map, throwError } from 'rxjs';
import { Router } from '@angular/router';

interface TransactionResponse {
  totalEntradas: number;
  // Adicione outras propriedades conforme necessário
}

@Injectable({
  providedIn: 'root'
})
export class AccountServiceService {
  private API_USER_INFO: string = 'http://localhost:8080/api/account';
  private API_TRANSACTION_INFO: string = 'http://localhost:8080/api/transaction';

  constructor(
    private http: HttpClient,
    private localStorage: StorageService,
    private router: Router
  ) { }

  getUserInfo(mail: string) {
    const authorization = this.localStorage.get('authorization');

    if (!authorization) {
      this.router.navigate(['/login']);
      return throwError('Authorization not found in localStorage');
    }

    const headers = {
      Authorization: 'Basic ' + authorization
    };

    const apiUrl = `${this.API_USER_INFO}/user-info/${mail}`

    return this.http.get(apiUrl).pipe(
      catchError(error => {
        console.error('Erro ao obter informações do usuário:', error);
        return throwError(error);
      })
    );
  }

  getTotalEntradas(cardId: number) {
    const authorization = this.localStorage.get('authorization');

    if (!authorization) {
      this.router.navigate(['/login']);
      return throwError('Authorization not found in localStorage');
    }

    const headers = {
      Authorization: 'Basic ' + authorization
    };

    const apiUrl = `${this.API_TRANSACTION_INFO}/allTransaction/inputs/${cardId}`

    return this.http.get<number>(apiUrl).pipe(
      catchError(error => {
        console.error('Erro ao obter informações do usuário:', error);
        return throwError(error);
      })
    );
  }

  getTotalSaidas(cardId: number) {
    const authorization = this.localStorage.get('authorization');

    if (!authorization) {
      this.router.navigate(['/login']);
      return throwError('Authorization not found in localStorage');
    }

    const headers = {
      Authorization: 'Basic ' + authorization
    };

    const apiUrl = `${this.API_TRANSACTION_INFO}/allTransaction/outputs/${cardId}`

    return this.http.get<number>(apiUrl).pipe(
      catchError(error => {
        console.error('Erro ao obter informações do usuário:', error);
        return throwError(error);
      })
    );
  }

  getTransactions(cardId: number) {
    const authorization = this.localStorage.get('authorization');

    if (!authorization) {
      this.router.navigate(['/login']);
      return throwError('Authorization not found in localStorage');
    }

    const headers = {
      Authorization: 'Basic ' + authorization
    };

    const apiUrl = `${this.API_TRANSACTION_INFO}/allTransaction/${cardId}`

    return this.http.get<number>(apiUrl).pipe(
      catchError(error => {
        console.error('Erro ao obter informações do usuário:', error);
        return throwError(error);
      })
    );
  }
}
