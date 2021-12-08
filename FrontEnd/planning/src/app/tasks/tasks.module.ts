import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MatCardModule } from '@angular/material/card';

import { TasksRoutingModule } from './tasks-routing.module';
import { TaskComponent } from './task/task.component';


@NgModule({
  declarations: [
    TaskComponent
  ],
  imports: [
    CommonModule,
    TasksRoutingModule,
    MatCardModule
  ]
})
export class TasksModule { }
