import {Component, EventEmitter, Output} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule, NgForm} from "@angular/forms";
import {ErrorDirective} from "../../../directives/error.directive";
import { AddRestoFormData } from './add-resto-form.dto';
import { Tag, TagLabels } from '../../../models/enum/tag.enum';

@Component({
  selector: 'app-add-resto-form',
  standalone: true,
  imports: [CommonModule, FormsModule, ErrorDirective],
  templateUrl: './add-resto-form.component.html',
  styleUrl: './add-resto-form.component.css'
})
export class AddRestoFormComponent {

  @Output("restoSubmitted") restoSubmittedEmiter = new EventEmitter<AddRestoFormData>();

  public formData: AddRestoFormData = {
    name: "",
    address: "",
    tag: 0
  }

  Tag = Tag;
  TagLabels = TagLabels;

  public submit(form: NgForm): void {
    if (form.valid) {
      this.restoSubmittedEmiter.emit(this.formData);
    }
  }

}
