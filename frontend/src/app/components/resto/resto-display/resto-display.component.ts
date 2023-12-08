import {Component, Input} from '@angular/core';
import {CommonModule, NgOptimizedImage} from '@angular/common';
import {RestoDto} from "../../../models/dto/resto.dto";
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-resto-display',
  standalone: true,
    imports: [CommonModule, NgOptimizedImage, RouterLink],
  templateUrl: './resto-display.component.html',
  styleUrl: './resto-display.component.css'
})
export class RestoDisplayComponent {

  constructor(private router: Router) {
  }

  @Input() restos: RestoDto[] = [];

  viewDetails(resto: RestoDto): void {
    this.router.navigate([`/restaurant/${resto.id}`]);
  }

}
