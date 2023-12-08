import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { XDisplayComponent } from "./x-display/x-display.component";
import { XModComponent } from "./x-mod/x-mod.component";

@Component({
  selector: 'app-x',
  standalone: true,
  imports: [CommonModule, XDisplayComponent, XModComponent],
  templateUrl: './x.component.html',
  styleUrl: './x.component.css'
})
export class XComponent {
  public x: number = 0;

  public addValue(value: number): void {
    if (this.x + value > 38) {
      this.x = 38;
    } else {
      this.x = this.x + value;
    }
  }

  public reset(): void {
    this.x = 0;
  }
}
