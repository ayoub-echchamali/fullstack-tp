import {Component, Input} from '@angular/core';
import {CommonModule, NgOptimizedImage} from '@angular/common';
import {YDto} from "../../../models/dto/y.dto";

@Component({
  selector: 'app-y-display',
  standalone: true,
    imports: [CommonModule, NgOptimizedImage],
  templateUrl: './y-display.component.html',
  styleUrl: './y-display.component.css'
})
export class YDisplayComponent {

  @Input() ys: YDto[] = [];

}
