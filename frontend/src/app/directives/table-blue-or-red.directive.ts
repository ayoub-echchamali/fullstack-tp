import {Directive, ElementRef, Input, Renderer2} from '@angular/core';

@Directive({
  selector: '[appTableBlueOrRed]',
  standalone: true
})
export class TableBlueOrRedDirective {

  @Input()
  set appTableBlueOrRed(value: string) {
    if (parseInt(value) % 2 === 0) {
      this.renderer.setStyle(this.elRef.nativeElement, "color", "blue");
    } else {
      this.renderer.setStyle(this.elRef.nativeElement, "color", "red");
    }
  }

  constructor(private elRef: ElementRef, private renderer: Renderer2) {
  }

}
