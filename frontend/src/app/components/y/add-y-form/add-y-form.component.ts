import {Component, EventEmitter, Output} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule, NgForm} from "@angular/forms";
import {ErrorDirective} from "../../../directives/error.directive";
import { AddYFormData } from './add-y-form.dto';

@Component({
  selector: 'app-add-y-form',
  standalone: true,
  imports: [CommonModule, FormsModule, ErrorDirective],
  templateUrl: './add-y-form.component.html',
  styleUrl: './add-y-form.component.css'
})
export class AddYFormComponent {

  @Output("ySubmitted") ySubmittedEmiter = new EventEmitter<AddYFormData>();

  public formData: AddYFormData = {
    titre: ""
  }

  public submit(form: NgForm): void {
    if (form.valid) {
      this.ySubmittedEmiter.emit(this.formData);
    }
  }

}
