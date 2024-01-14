import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { NgModule } from '@angular/core';
import { authGuard } from './services/auth.guard';

export const routes: Routes = [
    {path: 'login', component: LoginComponent},
    {path: 'home', component: HomeComponent},//, canActivate: [authGuard]},
    //{path: '**', component: PageNotFoundComponent},
    {path: '',   redirectTo: '/home', pathMatch: 'full' }
];   

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
  export class AppRoutingModule { }