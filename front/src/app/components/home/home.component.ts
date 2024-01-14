import { Component } from '@angular/core';
import { AccountServiceService } from '../../services/account-service/account-service.service';
import { Account } from '../../entities/account.model';
import { StorageService } from '../../services/storage/storage.service';
import { Router } from '@angular/router';
import { Transaction } from '../../entities/transaction.model';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  accountInstance: Account | undefined;
  userName: string = 'User';
  mail: string = 'user@user.com';
  loginFailMessage: string = '';

  totalEntradas: number = 0.0;
  totalSaidas: number = 0.0;
  totalAtual: number = 0.0;
  transactions: Transaction[] = [];

  constructor(
    private accountService: AccountServiceService,
    private router: Router,
    private localStorage: StorageService
  ){}
  ngOnInit(): void {
    var authorization = this.localStorage.get('authorization');

    if(authorization  == null){
      this.userName = 'Authorization not found';
      this.router.navigate(['/login']);
    }else{
      const decodedCredentials = atob(authorization);
      const [mail, _] = decodedCredentials.split(':');

      this.mail = mail;
      this.accountService.getUserInfo(mail).subscribe(
        (response) => {
          this.accountInstance = Account.fromJsonObj(response);
          this.userName = this.accountInstance.username;
        },
        (error) => {
          console.error('Erro ao obter informações do usuário:', error);
        }
      );

      // cardId mocado como  1
      this.accountService.getTotalEntradas(1).subscribe(
        (responseTotalEntradas) => {
          this.totalEntradas = responseTotalEntradas
        },
        (error) => {
          console.error('Erro ao obter informações do usuário:', error);
        }
      );

      // cardId mocado como  1
      this.accountService.getTotalSaidas(1).subscribe(
        (responseTotalSaidas) => {
          this.totalSaidas = responseTotalSaidas
          this.totalAtual = this.totalEntradas - this.totalSaidas;
        },
        (error) => {
          console.error('Erro ao obter informações do usuário:', error);
        }
      );

      /*
        this.accountService.getTransactions(1).subscribe(
          (transactionsResponse) => {
            this.transactions = transactionsResponse
          },
          (error) => {
            console.error('Erro ao obter informações do usuário:', error);
          }
        );
      */
      console.log("aguiar")
      console.log(this.transactions)
    }

    
  }
}
