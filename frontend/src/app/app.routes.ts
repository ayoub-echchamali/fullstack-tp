import {Routes} from '@angular/router';
import { XComponent } from './components/x/x.component';
import { YComponent } from './components/y/y.component';

export const routes: Routes = [
  {
    path: '', redirectTo: 'X', pathMatch: "full"
  },
  {
    path: 'X', component: XComponent
  },
  {
    path: 'Y', component: YComponent
  }
];
