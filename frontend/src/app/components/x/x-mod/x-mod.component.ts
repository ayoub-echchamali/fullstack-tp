import {Component, EventEmitter, Output} from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-x-mod',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './x-mod.component.html',
  styleUrl: './x-mod.component.css'
})
export class XModComponent {

  @Output() addValue: EventEmitter<number> = new EventEmitter<number>()
  @Output() reset: EventEmitter<void> = new EventEmitter<void>()

  public addValeur(value: number): void {
    this.addValue.emit(value);
  }

  public resetValeur(): void {
    this.reset.emit();
  }

}
