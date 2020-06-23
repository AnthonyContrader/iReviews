import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminLayoutComponent } from '../layout/admin-layout/admin-layout.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsersComponent } from './users/users.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { AuthGuard } from '../../guard/auth/auth.guard';
import { EsercizioComponent } from './esercizio/esercizio.component';
import { TipologiaComponent } from './tipologia/tipologia.component';
import { LocalitaComponent } from './localita/localita.component';
import { ReviewComponent } from './review/review.component';

/**
 * Modulo di routing dell'admin. Qui ci sono i percorsi che un admin può seguire:
 * appena fa il login viene caricato nel <router-outlet> di app-component il layout e nel
 * <router-outlet> del layout (come percorsi "children") vengono visualizzati gli altri
 * (qui sotto sono indentati). Si osservi il Guard "canActivate: [AuthGuard]" che protegge le routes
 * del'ADMIN dagli altri utenti.
 *
 * @author Vittorio Valent
 *
 * @see AdminLayoutComponent
 * @see AuthGuard
 * @see layout
 */
const routes: Routes = [
  {
    path: 'admin-dashboard', component: AdminLayoutComponent,children: [
      { path: '', component: AdminDashboardComponent },
      { path: 'users', component: UsersComponent },
      { path: 'esercizio', component: EsercizioComponent },
      { path: 'tipologia', component: TipologiaComponent },
      { path: 'localita', component: LocalitaComponent },
      { path: 'review', component: ReviewComponent },
      { path: 'work-in-progress', component: WorkInProgressComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
