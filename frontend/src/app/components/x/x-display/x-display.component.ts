import {Component, Input} from '@angular/core';
import {CommonModule} from '@angular/common';
import {TableBlueOrRedDirective} from "../../../directives/table-blue-or-red.directive";

@Component({
  selector: 'app-x-display',
  standalone: true,
  imports: [CommonModule, TableBlueOrRedDirective],
  templateUrl: './x-display.component.html',
  styleUrl: './x-display.component.css'
})
export class XDisplayComponent {

  public internalX: number = 0;

  public xTable: number[] = [];

  @Input()
  set x(value: number) {
    this.internalX = value;

    this.xTable = Array(this.internalX).fill(0).map((value1, index) => index);
  }

}
