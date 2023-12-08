import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestoDetailsDisplayComponent } from './resto-details-display.component';

describe('RestoDetailsDisplayComponent', () => {
  let component: RestoDetailsDisplayComponent;
  let fixture: ComponentFixture<RestoDetailsDisplayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RestoDetailsDisplayComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RestoDetailsDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
