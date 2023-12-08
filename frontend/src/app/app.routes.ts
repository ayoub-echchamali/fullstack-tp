import {Routes} from '@angular/router';
import { RestoComponent } from './components/resto/resto.component';
import { RestoDetailsComponent } from './components/resto-details/resto-details.component';

export const routes: Routes = [
  {
    path: '', component: RestoComponent
  },
  {
    path: 'restaurant/:id', component: RestoDetailsComponent
  }
];
